
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface AdministratorChartRepository extends AbstractRepository {

	@Query("SELECT a.sector, count(a) FROM InvestorRecords a WHERE a.sector IN (SELECT a.sector FROM Records a) GROUP BY a.sector")
	Object[] findInvestorsCommonSectors();

	@Query("SELECT a.sector, count(a) FROM Records a WHERE a.sector IN (SELECT a.sector FROM InvestorRecords a) GROUP BY a.sector")
	Object[] findCompaniesCommonSectors();

	@Query("SELECT a.sector, count(a) FROM Records a WHERE a.sector NOT IN (SELECT a.sector FROM InvestorRecords a) GROUP BY a.sector")
	Object[] findCompanySectors();

	@Query("SELECT a.sector, count(a) FROM InvestorRecords a WHERE a.sector NOT IN (SELECT a.sector FROM Records a) GROUP BY a.sector")
	Object[] findInvestorSectors();

}
