package se.jensensthlm.forexgump;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExchangeCalculatorTest {
    @InjectMocks
    ExchangeCalculator exchangeCalculator;

    @Mock
    ExchangeProvider exchangeProvider;

    final double AMOUNT = 100.0;
    final double RATE = 10.0;
    final String REFERENCECURRENCY = "SEK";
    final String TARGETCURRENCY = "GBP";



    @Test
    @DisplayName("Buy 100 GBP")
    public void TestBuy() {
        // Given the exchange rate 10 SEK / GBP
        // To buy 100 GBP
        // You need to pay 1000 SEK
    }

    @Test
    @DisplayName("Buying same currency as reference throws exception")
    public void TestBuyException(){

    }

    @Test
    @DisplayName("Sell 100 SEK to get GBP")
    public void TestSell() {
        // Given the exchange rate 10 SEK / GBP
        // Selling 100 SEK
        // Gives you 10 GBP
    }

    @Test
    @DisplayName("Selling same currency as reference throws exception")
    public void TestSellException(){

    }

    @Test
    @DisplayName("Requesting exchange rate provides the correct rate for given currency pair")
    public void TestGetExchangeRate(){

    }

    @Test
    @DisplayName("Requesting exchange rate between the same currency throws an exception")
    public void TestExchangeRateException(){

    }
}
