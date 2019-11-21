package com.eclorelavie.conveyorBelt;
import org.junit.Test;
import static org.junit.Assert.*;


  public ConveyorBelt createLoadedConveyor(int[] parcelNumbers) {
     ConveyorBelt belt = new ConveyorBelt(parcelNumbers.length);
     for (int number:parcelNumbers) {
         belt.put(getParcelByNumber(number));
     }
     return belt;
  }

  @Test
  public void skipNumbersLessThan10() {
    int[] parcelNumbers = new int[] {1, 14, 3, 20, 23, 42, 56};

    ConveyorBelt belt = createLoadedConveyor(parcelNumbers);
    int[] parcelLeft = conveyor.processParcels();

    assertThat(parcelLeft).isEqualTo(new int[]{1,3});
  }

  
