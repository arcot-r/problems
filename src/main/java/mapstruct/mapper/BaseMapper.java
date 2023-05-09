package mapstruct.mapper;

import java.util.Collection;

public interface BaseMapper<E, T> {
	T entityToDTO(E e);
	E DTOToEntity(T t);
	Collection<E> map(Collection<T> t);
}
