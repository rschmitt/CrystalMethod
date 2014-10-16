package com.github.rschmitt.crystalmethod;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CrystalMethod {
    @SuppressWarnings("unchecked")
    public static <T extends Multimethod<D, T1, R>, D, T1, R> T buildMultimethod(
            Function<T1, D> dispatchFn,
            Map<D, Function<T1, R>> methods,
            Class<T> type
    ) {
        Map<D, Function<T1, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0]);
                    return myCopy.get(dispatchVal).apply((T1) args[0]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod2<D, T1, T2, R>, D, T1, T2, R> T buildMultimethod(
            Function2<T1, T2, D> dispatchFn,
            Map<D, Function2<T1, T2, R>> methods,
            Class<T> type
    ) {
        Map<D, Function2<T1, T2, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod3<D, T1, T2, T3, R>, D, T1, T2, T3, R> T buildMultimethod(
            Function3<T1, T2, T3, D> dispatchFn,
            Map<D, Function3<T1, T2, T3, R>> methods,
            Class<T> type
    ) {
        Map<D, Function3<T1, T2, T3, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod4<D, T1, T2, T3, T4, R>, D, T1, T2, T3, T4, R> T buildMultimethod(
            Function4<T1, T2, T3, T4, D> dispatchFn,
            Map<D, Function4<T1, T2, T3, T4, R>> methods,
            Class<T> type
    ) {
        Map<D, Function4<T1, T2, T3, T4, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod5<D, T1, T2, T3, T4, T5, R>, D, T1, T2, T3, T4, T5, R> T buildMultimethod(
            Function5<T1, T2, T3, T4, T5, D> dispatchFn,
            Map<D, Function5<T1, T2, T3, T4, T5, R>> methods,
            Class<T> type
    ) {
        Map<D, Function5<T1, T2, T3, T4, T5, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod6<D, T1, T2, T3, T4, T5, T6, R>, D, T1, T2, T3, T4, T5, T6, R> T buildMultimethod(
            Function6<T1, T2, T3, T4, T5, T6, D> dispatchFn,
            Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> methods,
            Class<T> type
    ) {
        Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod7<D, T1, T2, T3, T4, T5, T6, T7, R>, D, T1, T2, T3, T4, T5, T6, T7, R> T buildMultimethod(
            Function7<T1, T2, T3, T4, T5, T6, T7, D> dispatchFn,
            Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> methods,
            Class<T> type
    ) {
        Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod8<D, T1, T2, T3, T4, T5, T6, T7, T8, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, R> T buildMultimethod(
            Function8<T1, T2, T3, T4, T5, T6, T7, T8, D> dispatchFn,
            Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> methods,
            Class<T> type
    ) {
        Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6], (T8) args[7]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6], (T8) args[7]);
                });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Multimethod9<D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> T buildMultimethod(
            Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, D> dispatchFn,
            Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> methods,
            Class<T> type
    ) {
        Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> myCopy = new HashMap<>();
        myCopy.putAll(methods);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{type},
                (Object proxy, Method method, Object[] args) -> {
                    if ("getDispatchFn".equals(method.getName()))
                        return dispatchFn;
                    else if ("getDispatchMap".equals(method.getName()))
                        return Collections.unmodifiableMap(myCopy);
                    D dispatchVal = dispatchFn.apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6], (T8) args[7], (T9) args[8]);
                    return myCopy.get(dispatchVal).apply((T1) args[0], (T2) args[1], (T3) args[2], (T4) args[3], (T5) args[4], (T6) args[5], (T7) args[6], (T8) args[7], (T9) args[8]);
                });
    }

}
