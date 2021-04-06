package bm.app.apigithubuser.service;

import bm.app.apigithubuser.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

        UserService userService;
        UserService userServiceMock;

    @Test
        @DisplayName("Should return a full name of the least starred project of the user.")
        void shouldReturnTheFullNameOfTheFirstRepoForTheUserInAscendingOrderByStars() throws IOException {
            //given
            String name = "pjhyett";
            //when
            User[] resultArray = userService.fetchUserByStarsAscendingOrder(name);
            //then
            assertThat(resultArray[0].getFull_name()).isEqualTo("pjhyett/github-services");
        }

        @Test
        @DisplayName("Should return a full name of the most starred project of the user.")
        void shouldReturnTheFullNameOfTheFirstRepoForTheUserInDescendingOrderByStars() throws IOException {
            //given
            String name = "pjhyett";
            //when
            User[] resultArray = userService.fetchUserByStarsDescendingOrder(name);
            //then
            assertThat(resultArray[0].getFull_name()).isEqualTo("pjhyett/git-server");
        }

        @Test
        @DisplayName("Should return given array when given String input.")
        void shouldReturnAnArray() throws IOException {
            //given
            String name = "pikachu";
            User[] pokemon = {new User("PikachuRepo",
                    "A lightningly good project",
                    "A pokeUrl",
                    100,
                    "2010-03-13T22:17:26Z")};
            Mockito.when(userServiceMock.fetchUser(name)).thenReturn(pokemon);
            //then
            assertThat(userServiceMock.fetchUser(name)).isEqualTo(pokemon);
        }

        @BeforeEach
        void setUp() {
            userService = new UserService();
            userServiceMock = Mockito.mock(UserService.class);
        }
}