package com.teabear.arlekin.utils;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of this class is for UNIT TESTING, it is in the main package
 * (versus a "test") package for use in other modules. It will swallow errors
 * purposely to avoid catching or declaring exceptions in unit tests.
 * 
 * @author Maximiliano Britez
 */
public final class ReflectionUtils {
    private static final Logger LOG = Logger.getLogger(ReflectionUtils.class.getCanonicalName());

    public static boolean doesFieldMatch(final Object obj, final String name, final String expectedValue) {

        final Object actualValue = getFieldValue(obj, name);
        if (actualValue == expectedValue) {
            return true;
        } else if (actualValue != null && actualValue.toString().equals(expectedValue)) {
            return true;
        }
        return false;
    }

    private static Field getField(final Class<?> clazz, final String name) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(name);
        } catch (final NoSuchFieldException e) {
            if (clazz.getSuperclass() != null) {
                return getField(clazz.getSuperclass(), name);
            }
            throw e;
        }
    }

    public static Object getFieldValue(final Object obj, final String name) {

        try {
            final Field field = getField(obj.getClass(), name);
            field.setAccessible(true);
            return field.get(obj);
        } catch (final Throwable e) {
            LOG.log(Level.INFO, "could not set field", e);
        }
        return null;
    }

    public static void setField(final Object obj, final String name, final Object value) {

        try {
            final Field field = getField(obj.getClass(), name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (final Throwable e) {
            LOG.log(Level.INFO, "could not set field", e);
        }
    }

}
