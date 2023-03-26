package gb.homeworks.hw7.controller;

import gb.homeworks.hw7.entity.Student;
import gb.homeworks.hw7.exceptions.StudentNotFoundException;
import gb.homeworks.hw7.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Students", description = "Methods to work with Students table")
public class StudentController {
    private final StudentService service;

    @GetMapping("/all")
    @Operation(
            summary = "Request for getting list of all students",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = List.class))
                    )
            }
    )
    public List<Student> getAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Request for getting student by id",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Student.class))
                    ),
                    @ApiResponse(
                            description = "Student not found in DB", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public Student getById(@PathVariable @Parameter(description = "Student's id", required = true) Integer id){
        return service.findById(id);
    }

    @GetMapping()
    @Operation(
            summary = "Request for getting students page",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class))
                    )
            }
    )
    public Page<Student> getStudents(@RequestParam(name = "page", defaultValue = "1") Integer page){
        return service.listByPage(page);
    }

    @PostMapping()
    @Operation(
            summary = "Request for adding new student to DB",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Student.class))
                    )
            }
    )
    public Student addNewStudent(@RequestBody @Parameter(description = "new object with empty ID", required = true) Student student){
        return service.addNew(student);
    }

    @Operation(
            summary = "Request for updating student in DB",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Student not found in DB", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    @PutMapping()
    public void updateStudent(@RequestBody @Parameter(description = "updated object", required = true) Student student){
        service.updateStudent(student);
    }

    @Operation(
            summary = "Request for deleting student from DB",
            responses = {
                    @ApiResponse(
                            description = "Success response", responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Student not found in DB", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable @Parameter(description = "Student's id", required = true) Integer id){
        service.deleteStudent(id);
    }

}
