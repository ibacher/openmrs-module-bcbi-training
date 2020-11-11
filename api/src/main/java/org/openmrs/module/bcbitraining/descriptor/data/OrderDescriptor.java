package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Order;

@EqualsAndHashCode(callSuper = false)
@Data
public class OrderDescriptor extends DataDescriptor<Order> {

	private String uuid;

	private OrderDescriptor previousOrder;

	private ConceptDescriptor concept;

	private String instructions;

	private Date dateActivated;

	private Date scheduledDate;

	private Date autoExpireDate;

	private Integer accessionNumber;

	private Order.Urgency urgency;

	private Order.Action action;

	private Integer orderNumber;

	private String commentToFulfiller;

	private ProviderDescriptor orderer;

}
