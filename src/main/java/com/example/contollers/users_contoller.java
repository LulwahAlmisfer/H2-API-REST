package com.example.contollers;
import com.example.models.UserTable;
import com.example.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller("api/user")
public class users_contoller {

    private final UserService userService;

    public users_contoller(UserService userService) {
        this.userService = userService;
    }



    @Get
    public HttpResponse<List<UserTable>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Get("/{id}")
    public HttpResponse<UserTable> getUser(@PathVariable int id) {
        return HttpResponse.ok(userService.getUser(id));
    }
    @Post
    public HttpResponse<UserTable> createUser(@Body @Valid UserTable userTable) {
        return HttpResponse.created(userService.createUser(userTable));
    }

    @Put("/{id}")
    public HttpResponse<UserTable> updateUser(@PathVariable int id, @Body UserTable user) {
        return HttpResponse.ok(userService.updateUser(id, user));
    }

    @Delete("/{id}")
    public HttpResponse deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
       return HttpResponse.ok();
    }


}
