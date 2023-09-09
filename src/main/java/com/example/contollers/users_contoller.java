package com.example.contollers;
import com.example.models.UserTable;
import com.example.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("api")
public class users_contoller {

    private final UserService userService;

    public users_contoller(UserService userService) {
        this.userService = userService;
    }

    @Get
    public HttpResponse<List<UserTable>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Post
    public HttpResponse<UserTable> createUser(@Body @Valid UserTable userTable) {
        return HttpResponse.created(userService.createUser(userTable));
    }

}
