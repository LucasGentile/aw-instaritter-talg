package br.edu.tasima.aw.talg.instaritter.controller;

import br.edu.tasima.aw.talg.instaritter.model.Picture;
import br.edu.tasima.aw.talg.instaritter.repository.PictureRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration*/
public class PictureControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private PictureRepository repository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    //@Test
    public void Should_Show_All_Pictures_When_List_Have_Items() throws Exception {

        Picture pictureOne = new Picture();
        pictureOne.setDescription("picture_1");
        pictureOne.setPictureDate(LocalDateTime.MIN);
        pictureOne.setContent("0x10238102381028301239810238102830128301238012");
        pictureOne.setPictureId(1L);

        Picture pictureTwo = new Picture();
        pictureTwo.setDescription("picture_2");
        pictureTwo.setPictureDate(LocalDateTime.MIN);
        pictureTwo.setContent("0x98394583098450398987452934570923874520384203");
        pictureTwo.setPictureId(2L);

        given(repository.findAll()).willReturn(Arrays.asList(pictureOne, pictureTwo));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("uploadPictureForm"))
                .andExpect(model().attribute("pictureList", hasSize(2)))
                .andExpect(model().attribute("pictureList", hasItem(
                        allOf(
                                hasProperty("pictureId", is(1L)),
                                hasProperty("description", is("picture_1")),
                                hasProperty("pictureDate", is(LocalDateTime.MIN)),
                                hasProperty("content", is("0x10238102381028301239810238102830128301238012"))
                        )
                )))
                .andExpect(model().attribute("pictureList", hasItem(
                        allOf(
                                hasProperty("pictureId", is(2L)),
                                hasProperty("description", is("picture_2")),
                                hasProperty("pictureDate", is(LocalDateTime.MIN)),
                                hasProperty("content", is("0x98394583098450398987452934570923874520384203"))
                        )
                )));

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    //@Test
    public void Should_Get_Picture_By_Id_When_Exists() throws Exception {
        Picture found = new Picture();
        found.setDescription("picture_1");
        found.setPictureDate(LocalDateTime.MIN);
        found.setContent("0x10238102381028301239810238102830128301238012");
        found.setPictureId(1L);

        given(repository.findById(1L)).willReturn(java.util.Optional.of(found));

        mockMvc.perform(get("/picture?pictureId=", 1L))
                .andExpect(status().is(302))
                .andExpect(view().name("redirect:/"))
                .andExpect(flash().attribute("picture", found))
                ;

        verify(repository, times(1)).findById(1L);
        verifyNoMoreInteractions(repository);
    }
}
