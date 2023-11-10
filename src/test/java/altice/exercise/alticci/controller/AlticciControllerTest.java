package altice.exercise.alticci.controller;

        import altice.exercise.alticci.exception.ApiExceptionHandler;
        import altice.exercise.alticci.service.AlticciService;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.Mockito;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.junit.jupiter.SpringExtension;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;

        import java.math.BigInteger;

        import static org.mockito.ArgumentMatchers.any;
        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AlticciController.class)
class AlticciControllerTest {

    MockMvc mockMvc;

    @MockBean
    AlticciService alticciService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AlticciControllerImpl(alticciService)).setControllerAdvice(new ApiExceptionHandler()).build();
    }

    @Test
    void WhenGetSequenceNumber_ReturnOk() throws Exception {
        Mockito.when(alticciService.getSequenceNumber(any(Integer.class))).thenReturn(new BigInteger("1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/alticci/{n}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}