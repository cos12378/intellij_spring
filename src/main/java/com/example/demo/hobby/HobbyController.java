package com.example.demo.hobby;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@RestController
@RequestMapping("/api/v1/hobbies")
public class HobbyController{

    private final HobbyService hobbyService;


    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @PostMapping("/create/{memberId}")
    public ResponseEntity created(@PathVariable("memberId") Integer memberId
                                    ,@RequestBody HobbyDto request){
        hobbyService.create(memberId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
