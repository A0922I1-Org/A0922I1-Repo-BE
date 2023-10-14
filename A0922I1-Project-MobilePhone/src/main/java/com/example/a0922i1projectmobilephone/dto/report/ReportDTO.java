package com.example.a0922i1projectmobilephone.dto.report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String fromDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String toDate;
    @NotNull
    private String reportType;
    @NotNull
    private Integer productId;

}
