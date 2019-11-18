
package acme.features.provider.request2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests2.Request2;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequest2CreateService implements AbstractCreateService<Provider, Request2> {

	@Autowired
	ProviderRequest2Repository repository;


	@Override
	public boolean authorise(final Request<Request2> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Request2> request, final Request2 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "ticker", "deadline", "text", "reward");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("confirm", "false");
		} else {
			request.transfer(model, "confirm");
		}
	}

	@Override
	public void bind(final Request<Request2> request, final Request2 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public Request2 instantiate(final Request<Request2> request) {
		assert request != null;
		Request2 result;
		result = new Request2();
		return result;
	}

	@Override
	public void validate(final Request<Request2> request, final Request2 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		//assert !(entity.getReward().getAmount() > 0.);
		//assert this.esUnico(request, entity) != false;
		//Date moment = new Date(System.currentTimeMillis() - 1);
		//assert entity.getDeadline().after(moment);
		assert entity.getReward().getCurrency() != "EUR";

		Boolean isAccepted;
		Boolean isEur;

		isAccepted = request.getModel().getBoolean("confirm");
		errors.state(request, isAccepted, "confirm", "provider.request2.error.must-confirm");

		isEur = entity.getReward().getCurrency().equals("EUR");
		errors.state(request, isEur, "reward", "provider.request2.error.incorrect-currency");
	}

	@Override
	public void create(final Request<Request2> request, final Request2 entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
