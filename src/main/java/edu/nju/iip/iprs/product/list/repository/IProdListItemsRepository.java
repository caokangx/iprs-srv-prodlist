

/**
 * Project Name:com.sap.ems.config 
 * File Name:IValueListItemsRepository.java
 * Description: 
 * Copyright: Copyright (c) 2017 
 * Company:SAP
 * 
 * @author SAP
 * @date Jul 25, 2017 1:42:23 PM
 * @version 
 * @see
 * @since 
 */
 
package edu.nju.iip.iprs.product.list.repository;

import edu.nju.iip.iprs.product.list.model.ProdListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  * ClassName: IValueListItemsRepository
  * Description: Repository interface for value list items.
  * @author SAP
  * @version 
  * @see
  * @since 
  */

@Repository
public interface IProdListItemsRepository extends JpaRepository<ProdListItem, String>
{
//    save
}
 
