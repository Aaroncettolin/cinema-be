
INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (1, false, true, 200, 'Room 1', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (2, false, true, 200, 'Room 2', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (3, false, false, 200, 'Room 3', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (4, false, false, 200, 'Room 4', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (5, false, false, 200, 'Room 5', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (6, false, false, 200, 'Room 6', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (7, false, false, 200, 'Room 7', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (8, false, false, 200, 'Room 8', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (9, false, false, 200, 'Room 9', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (10, false, false, 200, 'Room 10', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (11, false, false, 200, 'Room 11', current_timestamp, current_timestamp);

INSERT INTO public.room(
	id, deleted, is_imax, capacity, room_name, created_at, updated_at)
	VALUES (12, false, false, 200, 'Room 12', current_timestamp, current_timestamp);

INSERT INTO public.director(
	id, name, surname, deleted, created_at, updated_at)
	VALUES (1, 'Aaron', 'Cettolin', false, current_timestamp, current_timestamp);

INSERT INTO public.director(
	id, name, surname, deleted, created_at, updated_at)
	VALUES (2, 'Francesco', 'Totti', false, current_timestamp, current_timestamp);

INSERT INTO public.film(
	id, deleted, end_date, start_date, created_at, updated_at, director_id, room_id, name, note)
	VALUES (1, false, '2024-02-18', '2024-02-01', current_timestamp, current_timestamp, 1, 1, 'La Grande scommessa', 'che film!');

INSERT INTO public.film(
	id, deleted, end_date, start_date, created_at, updated_at, director_id, room_id, name, note)
	VALUES (2, false, '2024-02-06', '2024-01-25', current_timestamp, current_timestamp, 2, 4, 'La Piccola scommessa', 'che film!');

INSERT INTO public.film(
	id, deleted, end_date, start_date, created_at, updated_at, director_id, room_id, name, note)
	VALUES (3, false, '2024-01-30', '2024-01-15', current_timestamp, current_timestamp, 1, 3, 'Nome film', 'che film!');