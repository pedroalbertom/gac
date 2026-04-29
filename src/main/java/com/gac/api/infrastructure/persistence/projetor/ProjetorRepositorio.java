public interface ProjetorRepositorio extends JpaRepository<ProjetorEntity, Long> {
    Optional<ProjetorEntity> findByPatrimonio(String patrimonio);
}