package com.wyhw.pmp.service.common;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:10
 */
public interface IParseService<M, E> {
    M parse2Model(E entity);
    E parse2Entity(M model);
}
