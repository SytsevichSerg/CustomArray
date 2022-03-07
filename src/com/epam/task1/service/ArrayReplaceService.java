
package com.epam.task1.service;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;

public interface ArrayReplaceService {
    void replaceAllValues(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllValuesAboveThis(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllValuesBelowThis(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllNegativeValues(EntityArray entityArray, int replacement) throws EntityArrayException;

    void replaceAllValuesStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllValuesAboveThisStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllValuesBelowThisStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException;

    void replaceAllNegativeValuesStream(EntityArray entityArray, int replacement) throws EntityArrayException;
}
