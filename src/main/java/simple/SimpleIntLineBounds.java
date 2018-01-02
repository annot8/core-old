package simple;

import io.annot8.core.bounds.IntLineBounds;
import lombok.Data;

@Data
public class SimpleIntLineBounds implements IntLineBounds {

  private int left;

  private int right;

}
