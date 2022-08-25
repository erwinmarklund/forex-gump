package se.jensensthlm.forexgump;

import org.junit.jupiter.api.Assertions;
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

        when(exchangeProvider.get(REFERENCECURRENCY, TARGETCURRENCY))
                .thenReturn(new ExchangeDetails(REFERENCECURRENCY, TARGETCURRENCY, RATE));

        var expectedPriceInSek = 1000.0;
        var actualPriceInSek = exchangeCalculator.calculateBuy(TARGETCURRENCY, AMOUNT);
        assertEquals(expectedPriceInSek, actualPriceInSek);
    }

    @Test

    @DisplayName("Buying same currency as reference throws exception")
    public void TestBuyException(){
        when(exchangeProvider.get(REFERENCECURRENCY, REFERENCECURRENCY))
                .thenReturn(new ExchangeDetails(REFERENCECURRENCY, REFERENCECURRENCY, RATE));

        Assertions.assertThrows(IllegalArgumentException.class, ()-> exchangeCalculator.calculateBuy(REFERENCECURRENCY,AMOUNT));
    }

    @Test
    @DisplayName("Sell 100 SEK to get GBP")
    public void TestSell() {

        when(exchangeProvider.get( REFERENCECURRENCY, TARGETCURRENCY))
                .thenReturn(new ExchangeDetails( REFERENCECURRENCY, TARGETCURRENCY, RATE));
        var exceptedPriceInSek = AMOUNT / RATE;
        var actualPriceInSek = exchangeCalculator.calculateSell(TARGETCURRENCY, AMOUNT);
        assertEquals(exceptedPriceInSek, actualPriceInSek);
    }

    @Test
    @DisplayName("Selling same currency as reference throws exception")
    public void TestSellException(){
        when(exchangeProvider.get(REFERENCECURRENCY, REFERENCECURRENCY))
                .thenReturn(new ExchangeDetails(REFERENCECURRENCY, REFERENCECURRENCY, RATE));

        Assertions.assertThrows(IllegalArgumentException.class, ()-> exchangeCalculator.calculateSell(REFERENCECURRENCY,AMOUNT));
    }
}
