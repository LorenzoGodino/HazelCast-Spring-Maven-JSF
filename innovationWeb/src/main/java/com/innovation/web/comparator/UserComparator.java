package com.innovation.web.comparator;
import java.util.Comparator;

import com.innovation.web.model.User;


/**
 * The Class UserComparator.
 */
public class UserComparator implements Comparator<User>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(User o1, User o2) {
		  return o1.getId() - o2.getId();
	}

}
