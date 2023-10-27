package com.example.a0922i1projectmobilephone.dto.supplier;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;


@Getter
@Setter

public class SupplierDtoCreateUpdate {
    private Integer supplierId;
    @NotEmpty(message = "Tên nhà cung cấp không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9-()*_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$")
    @NotEmpty
    private String supplierName;
    @Pattern(regexp = "^(0[1-9]\\d{8})$")
    @NotEmpty(message = "Số điện thoại không được để trống")
        private String supplierPhone;
    @Email
    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}$")
    private String supplierEmail;
    @Pattern(regexp = "^[a-zA-Z0-9-_/.()*ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ \n]+$")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierDtoCreateUpdate that = (SupplierDtoCreateUpdate) o;
        return Objects.equals(supplierId, that.supplierId) && Objects.equals(supplierName, that.supplierName) && Objects.equals(supplierPhone, that.supplierPhone) && Objects.equals(supplierEmail, that.supplierEmail) && Objects.equals(supplierAddress, that.supplierAddress);
    }


}
