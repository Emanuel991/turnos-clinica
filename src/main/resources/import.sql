INSERT INTO `obra_social` (`id`, `nombre`) VALUES (NULL, 'OSDE');
INSERT INTO `obra_social` (`id`, `nombre`) VALUES (NULL, 'COSALUD');
INSERT INTO `obra_social` (`id`, `nombre`) VALUES (NULL, 'ISJ');
INSERT INTO `obra_social` (`id`, `nombre`) VALUES (NULL, 'OSFATUM');
INSERT INTO `obra_social` (`id`, `nombre`) VALUES (NULL, 'OSMEDICA');
INSERT INTO `especialidad` (`id`, `nombre`) VALUES (NULL, 'OBSTETRICIA');
INSERT INTO `especialidad` (`id`, `nombre`) VALUES (NULL, 'CARDIOLOGIA');
INSERT INTO `especialidad` (`id`, `nombre`) VALUES (NULL, 'GINECOLOGIA');
INSERT INTO `usuario` (`id`, `enabled`, `password`, `role`, `username`) VALUES (NULL, b'1', 'rob', 'ROLE_MEDICO', 'roberto');
INSERT INTO `medico` (`id`, `nombre`, `especialidad_id`, `usuario_id`) VALUES (NULL, 'ROBERTO PEREZ', '2', '1');
INSERT INTO `usuario` (`id`, `enabled`, `password`, `role`, `username`) VALUES (NULL, b'1', 'mar', 'ROLE_MEDICO', 'maria');
INSERT INTO `medico` (`id`, `nombre`, `especialidad_id`, `usuario_id`) VALUES (NULL, 'MARIA SOTO', '1', '2');
INSERT INTO `usuario` (`id`, `enabled`, `password`, `role`, `username`) VALUES (NULL, b'1', 'car', 'ROLE_MEDICO', 'carla');
INSERT INTO `medico` (`id`, `nombre`, `especialidad_id`, `usuario_id`) VALUES (NULL, 'CARLA TORREZ', '3', '3');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '1', '1');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '1', '2');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '1', '5');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '2', '1');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '2', '2');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '3', '1');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '3', '2');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '3', '4');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '3', '5');
INSERT INTO `obra_social_medico` (`id`, `medico_id`, `obra_social_id`) VALUES (NULL, '3', '3');




