package com.github.rschmitt.crystalmethod;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class CrystalMethod {
    private static final ConcurrentMap<Class, Multimethod> globalMultimethods = new ConcurrentHashMap<>();

    public static <T extends Multimethod<D, T1, R>, D, T1, R> void defMulti(
            Function<T1, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod<D, T1, R>, D, T1, R> void addMethod(
            D dispatchVal,
            Function<T1, R> method,
            Class<T> type
    ) {
        globalMultimethods.compute(type, (t, m) -> {
            Map<D, Function<T1, R>> oldMap = m.getDispatchMap();
            Map<D, Function<T1, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod<D, T1, R>, D, T1, R> R invoke(Class<T> type, T1 arg1) {
        return (R) globalMultimethods.get(type).apply(arg1);
    }

    private static final ConcurrentMap<Class, Multimethod2> globalMultimethods2 = new ConcurrentHashMap<>();

    public static <T extends Multimethod2<D, T1, T2, R>, D, T1, T2, R> void defMulti(
            Function2<T1, T2, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod2 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods2.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod2<D, T1, T2, R>, D, T1, T2, R> void addMethod(
            D dispatchVal,
            Function2<T1, T2, R> method,
            Class<T> type
    ) {
        globalMultimethods2.compute(type, (t, m) -> {
            Map<D, Function2<T1, T2, R>> oldMap = m.getDispatchMap();
            Map<D, Function2<T1, T2, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod2<D, T1, T2, R>, D, T1, T2, R> R invoke(Class<T> type, T1 arg1, T2 arg2) {
        return (R) globalMultimethods2.get(type).apply(arg1, arg2);
    }

    private static final ConcurrentMap<Class, Multimethod3> globalMultimethods3 = new ConcurrentHashMap<>();

    public static <T extends Multimethod3<D, T1, T2, T3, R>, D, T1, T2, T3, R> void defMulti(
            Function3<T1, T2, T3, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod3 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods3.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod3<D, T1, T2, T3, R>, D, T1, T2, T3, R> void addMethod(
            D dispatchVal,
            Function3<T1, T2, T3, R> method,
            Class<T> type
    ) {
        globalMultimethods3.compute(type, (t, m) -> {
            Map<D, Function3<T1, T2, T3, R>> oldMap = m.getDispatchMap();
            Map<D, Function3<T1, T2, T3, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod3<D, T1, T2, T3, R>, D, T1, T2, T3, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3) {
        return (R) globalMultimethods3.get(type).apply(arg1, arg2, arg3);
    }

    private static final ConcurrentMap<Class, Multimethod4> globalMultimethods4 = new ConcurrentHashMap<>();

    public static <T extends Multimethod4<D, T1, T2, T3, T4, R>, D, T1, T2, T3, T4, R> void defMulti(
            Function4<T1, T2, T3, T4, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod4 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods4.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod4<D, T1, T2, T3, T4, R>, D, T1, T2, T3, T4, R> void addMethod(
            D dispatchVal,
            Function4<T1, T2, T3, T4, R> method,
            Class<T> type
    ) {
        globalMultimethods4.compute(type, (t, m) -> {
            Map<D, Function4<T1, T2, T3, T4, R>> oldMap = m.getDispatchMap();
            Map<D, Function4<T1, T2, T3, T4, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod4<D, T1, T2, T3, T4, R>, D, T1, T2, T3, T4, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4) {
        return (R) globalMultimethods4.get(type).apply(arg1, arg2, arg3, arg4);
    }

    private static final ConcurrentMap<Class, Multimethod5> globalMultimethods5 = new ConcurrentHashMap<>();

    public static <T extends Multimethod5<D, T1, T2, T3, T4, T5, R>, D, T1, T2, T3, T4, T5, R> void defMulti(
            Function5<T1, T2, T3, T4, T5, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod5 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods5.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod5<D, T1, T2, T3, T4, T5, R>, D, T1, T2, T3, T4, T5, R> void addMethod(
            D dispatchVal,
            Function5<T1, T2, T3, T4, T5, R> method,
            Class<T> type
    ) {
        globalMultimethods5.compute(type, (t, m) -> {
            Map<D, Function5<T1, T2, T3, T4, T5, R>> oldMap = m.getDispatchMap();
            Map<D, Function5<T1, T2, T3, T4, T5, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod5<D, T1, T2, T3, T4, T5, R>, D, T1, T2, T3, T4, T5, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5) {
        return (R) globalMultimethods5.get(type).apply(arg1, arg2, arg3, arg4, arg5);
    }

    private static final ConcurrentMap<Class, Multimethod6> globalMultimethods6 = new ConcurrentHashMap<>();

    public static <T extends Multimethod6<D, T1, T2, T3, T4, T5, T6, R>, D, T1, T2, T3, T4, T5, T6, R> void defMulti(
            Function6<T1, T2, T3, T4, T5, T6, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod6 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods6.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod6<D, T1, T2, T3, T4, T5, T6, R>, D, T1, T2, T3, T4, T5, T6, R> void addMethod(
            D dispatchVal,
            Function6<T1, T2, T3, T4, T5, T6, R> method,
            Class<T> type
    ) {
        globalMultimethods6.compute(type, (t, m) -> {
            Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> oldMap = m.getDispatchMap();
            Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod6<D, T1, T2, T3, T4, T5, T6, R>, D, T1, T2, T3, T4, T5, T6, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6) {
        return (R) globalMultimethods6.get(type).apply(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final ConcurrentMap<Class, Multimethod7> globalMultimethods7 = new ConcurrentHashMap<>();

    public static <T extends Multimethod7<D, T1, T2, T3, T4, T5, T6, T7, R>, D, T1, T2, T3, T4, T5, T6, T7, R> void defMulti(
            Function7<T1, T2, T3, T4, T5, T6, T7, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod7 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods7.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod7<D, T1, T2, T3, T4, T5, T6, T7, R>, D, T1, T2, T3, T4, T5, T6, T7, R> void addMethod(
            D dispatchVal,
            Function7<T1, T2, T3, T4, T5, T6, T7, R> method,
            Class<T> type
    ) {
        globalMultimethods7.compute(type, (t, m) -> {
            Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> oldMap = m.getDispatchMap();
            Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod7<D, T1, T2, T3, T4, T5, T6, T7, R>, D, T1, T2, T3, T4, T5, T6, T7, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7) {
        return (R) globalMultimethods7.get(type).apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static final ConcurrentMap<Class, Multimethod8> globalMultimethods8 = new ConcurrentHashMap<>();

    public static <T extends Multimethod8<D, T1, T2, T3, T4, T5, T6, T7, T8, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, R> void defMulti(
            Function8<T1, T2, T3, T4, T5, T6, T7, T8, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod8 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods8.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod8<D, T1, T2, T3, T4, T5, T6, T7, T8, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, R> void addMethod(
            D dispatchVal,
            Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> method,
            Class<T> type
    ) {
        globalMultimethods8.compute(type, (t, m) -> {
            Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> oldMap = m.getDispatchMap();
            Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod8<D, T1, T2, T3, T4, T5, T6, T7, T8, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8) {
        return (R) globalMultimethods8.get(type).apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    private static final ConcurrentMap<Class, Multimethod9> globalMultimethods9 = new ConcurrentHashMap<>();

    public static <T extends Multimethod9<D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> void defMulti(
            Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod9 multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods9.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod9<D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> void addMethod(
            D dispatchVal,
            Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> method,
            Class<T> type
    ) {
        globalMultimethods9.compute(type, (t, m) -> {
            Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> oldMap = m.getDispatchMap();
            Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod9<D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>, D, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> R invoke(Class<T> type, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8, T9 arg9) {
        return (R) globalMultimethods9.get(type).apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }


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
