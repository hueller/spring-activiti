package de.hsansbach.wif.ebusiness.webshop.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import de.hsansbach.wif.ebusiness.webshop.NavigationHelper;
import de.hsansbach.wif.ebusiness.webshop.NavigationHelper.NavigationKey;

@Named
@Scope("session")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private NavigationHelper navigationHelper;

	private String username;

	public String login() {
		return navigationHelper.navigateTo(NavigationKey.MAIN);
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return navigationHelper.navigateTo(NavigationKey.LOGIN);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
