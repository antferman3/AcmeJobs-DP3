
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.banner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorBannerDeleteService implements AbstractDeleteService<Administrator, banner> {

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
	public banner findOne(final Request<banner> request) {
		assert request != null;

		banner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

	@Override
	public void validate(final Request<banner> request, final banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<banner> request, final banner entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
