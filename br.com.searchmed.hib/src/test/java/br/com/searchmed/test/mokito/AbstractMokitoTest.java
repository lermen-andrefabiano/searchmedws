package br.com.searchmed.test.mokito;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import br.com.searchmed.test.AbstractTest;

public abstract class AbstractMokitoTest extends AbstractTest {

    @Before
    public void setUpToAll() {
        MockitoAnnotations.initMocks(this);
    }

}
