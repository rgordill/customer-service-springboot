package org.sample;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data 
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(title = "Customer")
@JsonPropertyOrder({"id","first-name","last-name","email"})
@Entity
public class Customer implements Serializable {

	@Schema(title="UUID of a customer", readOnly=true )
	@JsonProperty("id")
	@Id
	private String id;
	
	@Schema(title="First Name" )
	@JsonProperty("first-name")
	private String firstName;
	
	@Schema(title="Last Name" )
	@JsonProperty("last-name")
	private String lastName;
	
	@Schema(title="Email" )
	@JsonProperty("email")
	private String email;

}