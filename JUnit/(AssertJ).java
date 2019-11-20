// Проверяем, что одно число больше другого
assertThat(count).isGreaterThan(original);
   
// Проверяем, содержание атрибутов объектов в массиве соответсвует ожидаемому
assertThat(counters).extracting("count")
                        .contains(1,3,4)
                        .doesNotContain(2);

