package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.repository.BaseRepository;

public abstract class BaseService<Repo extends BaseRepository<T, ?>, T> {

    protected Repo repository;

    public BaseService(Repo repository) {
        this.repository = repository;
    }

    public T save(T t) {
        return repository.save(t);
    }
}
