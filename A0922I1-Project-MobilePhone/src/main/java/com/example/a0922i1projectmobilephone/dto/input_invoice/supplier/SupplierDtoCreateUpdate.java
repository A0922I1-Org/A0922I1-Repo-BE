package com.example.a0922i1projectmobilephone.dto.input_invoice.supplier;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter

public class SupplierDtoCreateUpdate {
    private Integer supplierId;
    @NotEmpty(message = "Tên nhà cung cấp không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$")
    @NotEmpty
    private String supplierName;
    @Pattern(regexp = "([\\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})")
    @NotEmpty(message = "Số điện thoại không được để trống")
    private String supplierPhone;
    @Email
    @NotBlank(message = "Email không được để trống")
    private String supplierEmail;
    @Pattern(regexp = "^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ \n]+$")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String supplierAddress;

    public SupplierDtoCreateUpdate() {
    }

    public SupplierDtoCreateUpdate(int supplierId, String supplierName, String supplierPhone, String supplierEmail, String supplierAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
    }
    public SupplierDtoCreateUpdate( String supplierName, String supplierPhone, String supplierEmail, String supplierAddress) {

        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
    }

  }
