
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.banner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorBannerCreateService implements AbstractCreateService<Administrator, banner> {

	@Autowired
	AdministratorBannerRepository repository;


	@Override
	public boolean authorise(final Request<banner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<banner> request, final banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "targetURL");

	}

	@Override
	public void unbind(final Request<banner> request, final banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetURL");

	}

	@Override
	public banner instantiate(final Request<banner> request) {
		banner result;

		result = new banner();

		return result;
	}

	@Override
	public void validate(final Request<banner> request, final banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<banner> request, final banner entity) {

		this.repository.save(entity);

	}

}
