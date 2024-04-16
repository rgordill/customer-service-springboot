package org.sample;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositorySpring extends CrudRepository<Customer,String>{

    public @NonNull Optional<Customer> findById(@NonNull String id);

    public @NonNull <S extends Customer> S save(@NonNull S customer);

    public void deleteById(@NonNull String id);
}