package store.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private int proId;
    private String proName;
    private String proModel;
    private int proPrice;
    private double proSize;
}
