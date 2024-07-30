package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.Params;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParamsRepository extends JpaRepository<Params, String> {
}
