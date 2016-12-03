package br.unicamp.mc437.sade.dataService;
import java.util.List;

import br.unicamp.mc437.sade.DAO.GenericDAO;

public interface GenericService<T> extends GenericDAO<T> {
  List<T> getAll();
  void deleteAll();
}
