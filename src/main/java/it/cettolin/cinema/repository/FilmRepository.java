package it.cettolin.cinema.repository;

import it.cettolin.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByStartDateBetween(Date startDate, Date endDate);

    List<Film> findByStartDateBeforeAndEndDateAfter(Date endDate, Date startDate);

}
