#!/usr/bin/env perl -w

use v5.16;
use strict;

sub main {
  write_file("CrystalMethod.java", gen_builder_class());
  for my $i (1..9) {
    my $suffix = suffix($i);
    write_file("Multimethod$suffix.java", gen_multimethod_interface($i));
    write_file("Function$suffix.java", gen_functional_interface($i)) unless $i == 1;
  }
}

sub write_file {
  my ($filename, $content) = @_;
  open(my $fh, ">", "src/main/java/com/github/rschmitt/crystalmethod/$filename")
    or die "Unable to open $filename for write: $!";
  print $fh $content;
  close $fh;
}

sub gen_builder_class {
  my @methods;
  for my $i (1..9) {
    push @methods, gen_builder_method($i);
  }
  my $m = join "\n", @methods;
  return <<HERE
package com.github.rschmitt.crystalmethod;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CrystalMethod {
$m
}
HERE
}

sub gen_builder_method {
  my $count = shift;
  my $multimethod = gen_multimethod($count);
  my $dispatchFn = gen_function($count, "D");
  my $function = gen_function($count, "R");
  my $typeVars = gen_type_vars($count);
  my $args = get_args($count);
  return <<HERE
    \@SuppressWarnings("unchecked")
    public static <T extends $multimethod, D, $typeVars, R> T buildMultimethod(
            $dispatchFn dispatchFn,
            Map<D, $function> methods,
            Class<T> type
    ) {
        Map<D, $function> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply($args);
                    return myCopy.get(dispatchVal).apply($args);
                });
    }
HERE
}

sub get_args {
  my $count = shift;
  my @args;
  for my $i (1..$count) {
    my $idx = $i - 1;
    push @args, "(T$i) args[$idx]";
  }
  return join ", ", @args;
}

sub gen_multimethod_interface {
  my $count = shift;
  my $args = gen_param_list($count);
  my $function = gen_function($count, "R");
  my $dispatchFn = gen_function($count, "D");
  my $multimethod = gen_multimethod($count);
  return <<HERE
package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

\@FunctionalInterface
public interface $multimethod extends $function {
    default Map<D, $function> getDispatchMap() {
        return null;
    }

    default $dispatchFn getDispatchFn() {
        return null;
    }
}
HERE
}

sub gen_functional_interface {
  my $count = shift;
  my $function = gen_function($count, "R");
  my $args = gen_param_list($count);
return <<HERE
package com.github.rschmitt.crystalmethod;

\@FunctionalInterface
public interface $function {
    R apply($args);
}
HERE
}

sub gen_function {
  my ($count, $returnType) = @_;
  my $suffix = suffix($count);
  my $typeVars = gen_type_vars($count);
  return "Function$suffix<$typeVars, $returnType>";
}

sub gen_multimethod {
  my ($count, $returnType) = @_;
  my $suffix = suffix($count);
  my $typeVars = gen_type_vars($count);
  return "Multimethod$suffix<D, $typeVars, R>";
}

sub gen_type_vars {
  my ($count) = @_;
  my @vars;
  for my $i (1..$count) {
    push @vars, "T$i";
  }
  return join ", ", @vars;
}

sub gen_param_list {
  my $count = shift;
  my @params;
  for my $i (1..$count) {
    push @params, "T$i arg$i";
  }
  return join ", ", @params;
}

sub suffix {
  my ($arity) = @_;
  if ($arity == 1) {
    return "";
  } else {
    return "$arity";
  }
}

main();
