public class InformerTest {
  @Test
  public shouldReportCorrectValues() {
     // Создаем имитацию класса и задаем ее поведение
     Restaraunt mockedPlace = Mockito.mock(Restaraunt.clas);
     when(mockedPlace.getFreeSeats()).thenReturn(42);
     when(mockedPlace.getOccupiedSeats()).thenReturn(42);

     // Тестириуем обычным образом
     Informer informerUnderTest = new Informer(new RestarauntStub());
     String message = informerUnderTest.describe();
     assertThat(message).isEqualTo("42 seats free, 56 seats occupied");

     // Проверяем, что на нашем объекте были вызваны
     // ожидаемые методы
     Mockito.verify(mockedPlace).getFreeSeats();
     Mockito.verify(mockedPlace).getOccupiedSeats();
  }
}
