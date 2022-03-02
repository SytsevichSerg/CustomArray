
package com.epam.task1.service;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;

public interface ArrayProcessService {
    int     findMax(EntityArray array) throws EntityArrayException;

    int     finddMin(EntityArray array) throws EntityArrayException;

    double  calcSumm(EntityArray array) throws EntityArrayException;

    double  calcAverage(EntityArray array) throws EntityArrayException;

    int     countPositive(EntityArray array) throws EntityArrayException;

    int     countNegative(EntityArray array) throws EntityArrayException;

    int     findMaxStream(EntityArray array) throws EntityArrayException;

    int     findMinStream(EntityArray array) throws EntityArrayException;

    double  calcSummStream(EntityArray array) throws EntityArrayException;

    double  calcAverageStream(EntityArray array) throws EntityArrayException;

    int     countPositiveStream(EntityArray array) throws EntityArrayException;

    int     countNegativeStream(EntityArray array) throws EntityArrayException;
}
