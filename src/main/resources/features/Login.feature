Feature: Proses user Login
  Scenario: pengguna dapat login ke dalam sistem dengan sukses menggunakan kredensial yang benar.
    Given Pengguna mengakses halaman login
    When Pengguna memasukan username yang valid
    And Pengguna memasukkan password kredensial yang valid
    And Pengguna menekan tombol Login
    Then User berhasil login dan diarahkan ke halaman urama atau dashboard setelah login


Feature: Proses user Login dengan password salah
  Scenario: pengguna tidak dapat login ke dalam sistem dengan krudensial yang salah.
    Given Pengguna berada pada halaman login
    When Pengguna memasukan username yang valid
    And Pengguna memasukkan password kredensial yang tidak valid
    And Pengguna menekan tombol Login
    Then User tidak berhasil login dan mendapatkan feedback invalid credential
