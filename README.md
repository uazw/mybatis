# mybatis
demo of mybatis new feature issue

## install

* execute the sql file to your postgres 
* change the database.properties
* ./gradlew build

## MyBatis version
3.4.1

## Database vendor and version
postgres 9.4.6.1
mysql 5.6
## Test case or example project
```
public class Address {

    private long addressId;
    private String streetName;


    public Address(Integer addressId, String streetName) {
        this.addressId = addressId;
        this.streetName = streetName;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }
}
```

```
public interface AddressMapper
@Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    Address findAddressByIdUsingConstructor(long addressId);

```

```
CREATE TABLE address 
(
      address_id SERIAL PRIMARY KEY,
      street_name CHARACTER VARYING(255) NOT NULL
);

insert into address(address_id, street_name) values (1, 'chengdu')
```
## Steps to reproduce

So this bug is happened only with high version of Mybatis, which means there should be a method

called **createByConstructorSignature** in **DefaultResultSetHandler.java**,

During Debugging, I notice this method do prefect job creating object using non-default constructor which is 

```
    public Address(Integer addressId, String streetName) {
        this.addressId = addressId;
        this.streetName = streetName;
    }
```
for my Address, and at that time the flag variable -- *foundValues* is **true**.

But after this method is executed, program will continue the logic of **DefaultResultSetHandler.getRowValue** method,

this method will check again if mybatis really found some value, however at this time the *foundValues* is **false**.

## possible solution

For me, the easy way to solve this issue is at the last of **createByConstructorSignature** method,

we can update **resultMap.constructorResultMappings** so at **DefaultResultSetHandler.getRowValue** we can got true at

```
      boolean foundValues = resultMap.getConstructorResultMappings().size() > 0;
```

## Expected result

address(1, "chengdu")

## Actual result

null
