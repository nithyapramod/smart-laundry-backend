package com.swasth.smartlaundry.repository;

import java.util.List;

import com.swasth.smartlaundry.entity.NearByShops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NearByShopsRepository extends JpaRepository<NearByShops, String>{
	
	@Query(value = "SELECT uuid,shop_name,phone_number,address,ROUND(111.045 * DEGREES(ACOS(COS(RADIANS(:latitude))  * COS(RADIANS(lat))  * COS(RADIANS(lng) - RADIANS(:longitude))  + SIN(RADIANS(lat))  * SIN(RADIANS(:latitude)))),2)  AS  distance_in_km FROM  users  where status='A' and user_type=:userType ORDER BY distance_in_km ASC LIMIT 0,1",nativeQuery = true)
	List<NearByShops> findByShopName(@Param("latitude") Double lat,@Param("longitude") Double lng,@Param("userType") int userType);
 
	
	@Query(value = "SELECT uuid,shop_name,phone_number,address,ROUND(111.045 * DEGREES(ACOS(COS(RADIANS(:latitude))  * COS(RADIANS(lat))  * COS(RADIANS(lng) - RADIANS(:longitude))  + SIN(RADIANS(lat))  * SIN(RADIANS(:latitude)))),2)  AS  distance_in_km FROM  users  where status='A'  and user_type=:userType ORDER BY distance_in_km ASC  LIMIT 0,1",nativeQuery = true)
	List<NearByShops> nearByAllShops(@Param("latitude") Double lat,@Param("longitude") Double lng,@Param("userType") int userType);

}
