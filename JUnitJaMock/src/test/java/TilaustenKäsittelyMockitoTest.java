import mockesimerkki.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TilaustenKäsittelyMockitoTest {
    @Mock
    IHinnoittelija hinnoittelijaMock;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest(name = "Testataan {index}" +
            " - Tuotteenhinta: {0}")
    @ValueSource(floats = {30.0f, 100.0f})
    public void testaaKäsittelijäWithMockitoHinnoittelija(float hinta) {
        // Arrange
        float alkuSaldo = 100.0f;
        float listaHinta = hinta;
        float alennus = 20.0f;
        float loppuSaldo = listaHinta < 100 ? alkuSaldo - (listaHinta * (1 - alennus / 100)) : alkuSaldo - (listaHinta * (1 - (alennus + 5) / 100));
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        // Record
        when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
                .thenReturn(alennus)
                .thenReturn(alennus + 5.0f);
        // Act
        TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
        käsittelijä.setHinnoittelija(hinnoittelijaMock);
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));

        // Assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelijaMock, atLeastOnce()).getAlennusProsentti(asiakas, tuote);
    }
}
