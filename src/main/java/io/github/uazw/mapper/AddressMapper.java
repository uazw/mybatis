package io.github.uazw.mapper;

import io.github.uazw.domain.Address;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {

    @Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    Address findAddressByIdUsingConstructor(long addressId);
}
