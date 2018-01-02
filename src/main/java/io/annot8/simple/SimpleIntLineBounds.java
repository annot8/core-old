package io.annot8.simple;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.IntLineBounds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleIntLineBounds implements IntLineBounds {

  private int left;

  private int right;


  @Override
  public Bounds copy() {
    return new SimpleIntLineBounds(left, right);
  }
}
