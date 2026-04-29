@Component
public class ChaveGatewayImpl implements ChaveGateway {
    private final ChaveRepository repository;

    public ChaveGatewayImpl(ChaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public Chave salvar(Chave c) {
        ChaveEntity entity = repository.save(new ChaveEntity(
            c.getId(), c.getSala(), c.getBloco(), c.getStatus()
        ));
        return toDomain(entity);
    }

    @Override
    public List<Chave> listarTodos() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Chave> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Chave toDomain(ChaveEntity e) {
        return new Chave(e.getId(), e.getSala(), e.getBloco(), e.getStatus());
    }
}