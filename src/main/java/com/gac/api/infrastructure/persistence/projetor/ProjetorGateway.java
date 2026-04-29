@Component
public class ProjetorGatewayImpl implements ProjetorGateway {
    private final ProjetorRepository repository;

    public ProjetorGatewayImpl(ProjetorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Projetor salvar(Projetor p) {
        ProjetorEntity entity = repository.save(new ProjetorEntity(
            p.getId(), p.getMarca(), p.getModelo(), p.getPatrimonio(), p.getStatus()
        ));
        return toDomain(entity);
    }

    @Override
    public List<Projetor> listarTodos() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Projetor> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Projetor> buscarPorPatrimonio(String patrimonio) {
        return repository.findByPatrimonio(patrimonio).map(this::toDomain);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Projetor toDomain(ProjetorEntity e) {
        return new Projetor(e.getId(), e.getMarca(), e.getModelo(), e.getPatrimonio(), e.getStatus());
    }
}