package com.briancalvo.repository;

import com.briancalvo.domain.Player;
import com.briancalvo.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Brian on 10/10/2016.
 */
public interface PlayerRepository extends JpaRepository<Player,Long>{

    //Spring Data Queries

    List<Player> findByName(String name);

    List<Player> findByPointsGreaterThanEqual(Integer points);

    List<Player> findByAssistsBetween(Integer min, Integer max);

    List<Player> findByPosition(String position);

    List<Player> findByDateGreaterThan(LocalDate date);

    List<Player> findByPoints(Integer points);

    List<Player> findByRebounds(Integer rebounds);

    List<Player> findByAssists(Integer assists);

    // JPL Queries

    @Query("SELECT player.position,AVG(player.points),AVG(player.rebounds),AVG(player.assists) from Player player GROUP BY player.position")
    List<Object[]> AvgPointsReboundsAssistsPerPosition();

    @Query("SELECT player.position,AVG(player.points),MAX(player.points),MIN(player.points),AVG(player.rebounds),MAX(player.rebounds),MIN(player.rebounds),AVG(player.assists),MAX(player.assists),MIN(player.assists) FROM Player player GROUP BY player.position")
    List<Object[]> AvgMaxMinPointsReboundsAssistsPerPosition();

    @Query("SELECT player FROM Player player WHERE player.team = :team")
    List<Player> findPlayerByTeam(@Param("team") Team team);

}
