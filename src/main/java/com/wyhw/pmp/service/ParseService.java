package com.wyhw.pmp.service;

/**
 * @author wanyanhw
 * @since 2023/3/27 16:12
 */
public interface ParseService<M, E> {
    E parse2Entity(M t);
    M parse2Model(E e);
}
