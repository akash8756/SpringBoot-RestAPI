package com.mongodbuserdetails.repositry;

import com.mongodbuserdetails.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity,String> {

  /*  @Query(value = "select email_id from person_details where to_char(CURRENT_DATE, 'MM-dd')=to_char(day_month, 'MM-dd')")
    List<PersonEntity> findAllByDayMonth();*/
}
