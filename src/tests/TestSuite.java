package tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite com as classes de teste, para que seja rodado os testes das classes informadas no {@code @SuiteClasses}
 * @author Filipe Wutzke
 */
@RunWith(Suite.class)
@SuiteClasses({
	//aqui vem as classes de teste
	CaixaEconomicaFederalTest.class,
})
public class TestSuite {
	
}